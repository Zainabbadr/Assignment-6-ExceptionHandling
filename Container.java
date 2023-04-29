

public class Container implements Comparable<Container> {
    private String uuid;
    private String shortname;
    private String longname;

    public Container(){
    }
    public String getUuid(){
        return uuid;
    }

    public void setUuid(String uuid){
        this.uuid = uuid;
    }

    public String getShortname(){
        return shortname;
    }

    public void setShortname(String shortname){
        this.shortname = shortname;
    }

    public String getLongname(){
        return longname;
    }

    public void setLongname(String longname){
        this.longname = longname;
    }

    @Override
    public String toString(){
        return "<CONTAINER UUID=\"" + this.getUuid() + "\">\n" +
                "    <SHORT-NAME>" + this.getShortname() + "</SHORT-NAME>\n" +
                "    <LONG-NAME>" + this.getLongname() + "</LONG-NAME>\n" +
                "</CONTAINER>\n";
    }

    @Override
    public int compareTo(Container o) {
        return this.getShortname().compareTo(o.getShortname());

    }
}
