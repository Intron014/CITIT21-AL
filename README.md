# AL Subject Code Repository

This is a repository containing all the code that is taught in the AL (Algorítmica y Complejidad) subject at the UPM. The purpose of this repository is to provide a centralized location for students to access all the code that is taught in the course.

## Table of Contents

- [Getting Started](#getting-started)
- [Programs in here](#other-stuff)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

To get started with the code in this repository, you will need to have a code editor installed on your computer. We recommend using IntelliJ.

Once you have a code editor installed, you can clone this repository to your computer using the following command:

```bash
git clone https://gitea.intron014.com/Intron014/CITIT21-AL.git
```

Alternatively, you can download the repository as a ZIP file by clicking the "Download ZIP" button on the GitHub page for this repository.

## Other Stuff
You might have noticed that there are two folders that have nothing to do with this subject. 
If you haven't, the folders are _PDF Extractor_ and _PDF Stitcher_. Those are separate Python programs that I (with some assistance) have created to build better slides for the subject.

### PDF Extractor
The Extractor searches rectangles bigger than the coordinates "standw" and "standh", one at the top and another one at the bottom of the page (which is the way slides are at the time of writing this program) from .pdf(s) inside the input folder. Then it grabs the images in those rectangles and puts them (ordered with a method that also orders them in GitHub [0s are your friend]) in a folder with the name of the .pdf where they came from inside the output folder. "What do I do with this?" you might be asking... Well, take a look at the next section, will you?

### PDF Stitcher
Ah, the jewel of the crown, this program grabs images in folders from the input folder and... stitches them into usable pdfs! Yeah, long gone are the days of zooming in and out trying to follow the class! Go wild :D


## Contributing

If you would like to contribute to this repository, you can do so by creating a pull request. Before you create a pull request, please make sure that your code follows the style and conventions used in the rest of the repository.

If you are unsure about how to contribute or have any questions, please feel free to open an issue on the Gitea page for this repository.

## License

This repository is licensed under the MIT License. See the [LICENSE](./LICENSE.md) file for more information.
