import sys
from .aggregator import aggregate_cve_info

def main():
    if len(sys.argv) != 2:
        print("Usage: python -m cve_info.cli <CVE-ID>")
        sys.exit(1)
    cve_id = sys.argv[1]
    data = aggregate_cve_info(cve_id)
    print(f"CVE Information for {cve_id}:")
    for source in data["sources"]:
        print(f"\nSource: {source['source']}")
        print(source)

if __name__ == "__main__":
    main() 