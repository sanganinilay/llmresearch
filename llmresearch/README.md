# CVE Info Fetcher

A Python project to fetch and display information about a given CVE ID from the National Vulnerability Database (NVD).

---
**Note:** This codebase was created by Nilay, the author of this repository, by prompting at [Cursor](https://www.cursor.so/).
---

## Project Structure

```
llmresearch/
├── README.md                # Project documentation and instructions
├── requirements.txt         # Python dependencies (nvdlib, requests)
├── cve_info/                # Main application package
│   ├── __init__.py          # Marks cve_info as a Python package
│   ├── cli.py               # Command-line interface for running the app
│   ├── aggregator.py        # Aggregates and normalizes CVE data (from NVD)
│   └── fetchers/            # Directory for data source fetchers
│       ├── __init__.py      # Marks fetchers as a Python subpackage
│       └── nvd.py           # Fetches CVE info from NVD using nvdlib
└── tests/
    └── test_nvd.py          # Unit test for the NVD fetcher
```

### File/Directory Explanations
- **README.md**: This file. Explains the project, setup, and usage.
- **requirements.txt**: Lists required Python packages (`nvdlib`, `requests`).
- **cve_info/**: Main application code.
  - **cli.py**: Entry point for the command-line interface. Takes a CVE ID and prints info.
  - **aggregator.py**: Calls fetchers and aggregates results (currently only NVD).
  - **fetchers/nvd.py**: Fetches CVE data from the National Vulnerability Database using `nvdlib`.
- **tests/test_nvd.py**: Simple test to verify the NVD fetcher returns the correct CVE ID.

## Features
- Fetches CVE details from the National Vulnerability Database (NVD) using the nvdlib library
- Command-line interface for easy use
- Modular structure for easy extension and testing

## Requirements
- Python 3.8 or higher
- pip3 (Python package installer)
- Internet connection (to fetch CVE data from NVD)

## Setup
1. **Clone the repository and navigate to the project directory:**
   ```bash
   cd /home/_nilay/llmresearch
   ```
2. **(Optional but recommended) Create and activate a virtual environment:**
   ```bash
   python3 -m venv venv
   source venv/bin/activate
   ```
3. **Install dependencies:**
   ```bash
   pip3 install -r requirements.txt
   ```

## How to Run the Application
From the project root (`/home/_nilay/llmresearch`), run:
```bash
PYTHONPATH=llmresearch python3 -m cve_info.cli CVE-2021-44228
```
Replace `CVE-2021-44228` with any valid CVE ID you want to look up.

Alternatively, you can:
```bash
cd llmresearch
python3 -m cve_info.cli CVE-2021-44228
```

## How it Works
- The CLI takes a CVE ID as input.
- It fetches information from the NVD using the `nvdlib` library.
- The result is printed to the terminal, including description, severity, and references.

## Testing
Run the unit test using:
```bash
PYTHONPATH=llmresearch pytest llmresearch/tests/test_nvd.py
```

## Extending the Project
To add a new data source, create a new fetcher module in `cve_info/fetchers/` and update `aggregator.py`.

## License
MIT 