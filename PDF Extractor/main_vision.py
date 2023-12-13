import cv2
import numpy as np
from PyPDF2 import PdfFileReader
from pdf2image import convert_from_path
import os
from PIL import Image

ppath = "a.pdf"


def find_rectangles(image):
    open_cv_image = np.array(image)
    img_gray = cv2.cvtColor(open_cv_image, cv2.COLOR_BGR2GRAY)

    _, thresholded = cv2.threshold(img_gray, 240, 255, cv2.THRESH_BINARY_INV)

    # Split the image into top and bottom halves
    height, width = img_gray.shape
    top_half = thresholded[0:height//2, :]
    bottom_half = thresholded[height//2:, :]

    # Find contours in the top half
    contours_top, _ = cv2.findContours(top_half, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)

    rectangles_top = []

    for contour in contours_top:
        epsilon = 0.02 * cv2.arcLength(contour, True)
        approx = cv2.approxPolyDP(contour, epsilon, True)

        if len(approx) == 4:
            x, y, w, h = cv2.boundingRect(contour)
            if w == 1000 and h == 750:
                rectangles_top.append((x, y, x+w, y+h))
                print(f"Rectangle found in top half with size {w}x{h}")

    # Find contours in the bottom half
    contours_bottom, _ = cv2.findContours(bottom_half, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)

    rectangles_bottom = []

    for contour in contours_bottom:
        epsilon = 0.02 * cv2.arcLength(contour, True)
        approx = cv2.approxPolyDP(contour, epsilon, True)

        if len(approx) == 4:
            x, y, w, h = cv2.boundingRect(contour)
            if w == 1000 and h == 750:
                # Adjust the y coordinates for the bottom half
                rectangles_bottom.append((x, y + height//2, x+w, y+h + height//2))
                print(f"Rectangle found in bottom half with size {w}x{h}")

    # Return the rectangles from the top half first, then the bottom half
    return rectangles_top + rectangles_bottom


#def extract_images(pdf_path):
#    output_folder = "cheese"
#    os.makedirs(output_folder, exist_ok=True)
#
#    pdf = PdfFileReader(pdf_path)
#    num_pages = pdf.getNumPages()
#
#    for i in range(num_pages):
#        print(f"Looking for rectangles in page {i+1}")
#        images = convert_from_path(pdf_path, first_page=i+1, last_page=i+1)
#        for j, image in enumerate(images):
#            rectangles = find_rectangles(image)
#            for k, coords in enumerate(rectangles):
#                # Crop image for the rectangle and save
#                cropped_image = image.crop(coords)
#                cropped_image.save(os.path.join(output_folder, f"output_{i*len(rectangles)+k+1}.png"))
#                print(f"Saved rectangle {k+1} from page {i+1} as output_{i*len(rectangles)+k+1}.png")

def extract_images(pdf_path):
    output_folder = "cheese"
    os.makedirs(output_folder, exist_ok=True)

    pdf = PdfFileReader(pdf_path)
    num_pages = pdf.getNumPages()

    # Calculate the maximum number and its number of digits
    max_num = num_pages * 2
    num_digits = len(str(max_num))

    for i in range(num_pages):
        print(f"Looking for rectangles in page {i+1}")
        images = convert_from_path(pdf_path, first_page=i+1, last_page=i+1)
        for j, image in enumerate(images):
            rectangles = find_rectangles(image)
            for k, coords in enumerate(rectangles):
                # Crop image for the rectangle and save
                cropped_image = image.crop(coords)
                # Format the output file name with leading zeros
                output_file = f"output_{(i*len(rectangles)+k+1):0{num_digits}d}.png"
                cropped_image.save(os.path.join(output_folder, output_file))
                print(f"Saved rectangle {k+1} from page {i+1} as {output_file}")

extract_images(ppath)