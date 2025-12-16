package Models;

public abstract class htmlContent {
    private String htmlContent;
    
    public htmlContent() {
        this.htmlContent = "";
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContentDefaultWay(String htmlGiven)
    {
        this.htmlContent = htmlGiven;
    }

    public abstract void setHtmlContent();
}