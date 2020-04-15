package com.example.coronaapivirus;

public class CasesByCountryReq extends BaseReq {

    public CasesByCountryReq.CasesByCountryListener listener;

    public interface CasesByCountryListener {
        void casesByCountryReqDone(String result);
    }

    public CasesByCountryReq(CasesByCountryReq.CasesByCountryListener listener) {
        this.listener = listener;
    }

    @Override
    public String getReqUrl() {
        return "https://coronavirus-monitor.p.rapidapi.com/coronavirus/cases_by_country.php?rapidapi-key=b296fcbc2dmsh6bfe7d8930db773p1e098ajsnf3c04b17ca0e";
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.casesByCountryReqDone(result);
    }
}

