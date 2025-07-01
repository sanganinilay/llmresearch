from .fetchers.nvd import fetch_cve_from_nvd

def aggregate_cve_info(cve_id: str) -> dict:
    """Aggregate CVE info from NVD only."""
    results = [
        fetch_cve_from_nvd(cve_id),
    ]
    return {"cve_id": cve_id, "sources": results} 