def test_fetch_cve_from_nvd():
    from cve_info.fetchers.nvd import fetch_cve_from_nvd
    result = fetch_cve_from_nvd("CVE-2023-12345")
    assert result["cve_id"] == "CVE-2023-12345" 