import cv2
import numpy as np
from PyPDF2 import PdfFileReader
from pdf2image import convert_from_path
import os
from PIL import Image

ppath = "a.pdf"

def find_rectangles(image):
    # Convert PIL Image to OpenCV format
    open_cv_image = np.array(image)
    img_gray = cv2.cvtColor(open_cv_image, cv2.COLOR_BGR2GRAY)

    # Threshold the image
    _, thresholded = cv2.threshold(img_gray, 240, 255, cv2.THRESH_BINARY_INV)

    # Find contours in the thresholded image
    contours, _ = cv2.findContours(thresholded, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)

    rectangles = []

    # Iterate over the contours
    for contour in contours:
        # Approximate the contour
        epsilon = 0.02 * cv2.arcLength(contour, True)
        approx = cv2.approxPolyDP(contour, epsilon, True)

        # If the contour has four vertices, it is a rectangle
        if len(approx) == 4:
            # Get the coordinates of the rectangle
            x, y, w, h = cv2.boundingRect(contour)

            # Check if the rectangle has a minimum size of 400x400
            if w >= 400 and h >= 400:
                rectangles.append((x, y, x+w, y+h))

    return rectangles


def extract_images(pdf_path):
    output_folder = "cheese"
    os.makedirs(output_folder, exist_ok=True)  # Create the output folder if it doesn't exist

    pdf = PdfFileReader(pdf_path)
    num_pages = pdf.getNumPages()

    for i in range(num_pages):
        images = convert_from_path(pdf_path, first_page=i+1, last_page=i+1)
        for j, image in enumerate(images):
            rectangles = find_rectangles(image)
            for k, coords in enumerate(rectangles):
                # Crop image for the rectangle and save
                cropped_image = image.crop(coords)
                cropped_image.save(os.path.join(output_folder, f"output_{i*len(rectangles)+k+1}.png"))

extract_images(ppath)