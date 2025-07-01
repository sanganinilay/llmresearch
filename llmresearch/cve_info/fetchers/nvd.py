import nvdlib

def fetch_cve_from_nvd(cve_id: str) -> dict:
    """Fetch CVE info from NVD by CVE ID. Returns a dict with the data or an error message."""
    try:
        results = nvdlib.searchCVE(cveId=cve_id)
        if results:
            cve = results[0]
            return {
                "source": "NVD",
                "cve_id": cve_id,
                "data": {
                    "description": cve.descriptions[0].value if cve.descriptions else None,
                    "published": getattr(cve, 'published', None),
                    "lastModified": getattr(cve, 'lastModified', None),
                    "severity": getattr(cve, 'v31severity', None),
                    "score": getattr(cve, 'v31score', None),
                    "vector": getattr(cve, 'v31vector', None),
                    "references": [ref.url for ref in getattr(cve, 'references', [])],
                }
            }
        else:
            return {"source": "NVD", "cve_id": cve_id, "error": "CVE not found"}
    except Exception as e:
        return {"source": "NVD", "cve_id": cve_id, "error": str(e)} 