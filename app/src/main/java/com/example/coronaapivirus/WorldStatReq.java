package com.example.coronaapivirus;

public class WorldStatReq extends BaseReq{
    public WorldStatReqListener listener;

    public interface WorldStatReqListener {
        void worldStatReqDone(String result);
    }

    public WorldStatReq(WorldStatReqListener listener) {
        this.listener = listener;
    }

    @Override
    public String getReqUrl() {
        return "https://coronavirus-monitor.p.rapidapi.com/coronavirus/worldstat.php?rapidapi-key=b296fcbc2dmsh6bfe7d8930db773p1e098ajsnf3c04b17ca0e";
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.worldStatReqDone(result);
    }
}
