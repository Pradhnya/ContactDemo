package models;

import scala.util.parsing.json.JSONObject;

public class GenderStat{

    int male;
    int female;

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }

    public int getFemale() {
        return female;
    }

    public void setFemale(int female) {
        this.female = female;
    }

    public String toJSONString(){
        StringBuffer sb = new StringBuffer();

        sb.append("[");

        sb.append("Male");
        sb.append(":");
        sb.append(this.getMale());

        sb.append("]");

        sb.append(",");

        sb.append("[");

        sb.append("Female");
        sb.append(":");
        sb.append(this.getFemale());

        sb.append("]");

        return sb.toString();
    }
}
