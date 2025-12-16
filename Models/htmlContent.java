package Models;

public abstract class htmlContent {
    private String htmlContent;
    
    public htmlContent() {
        this.htmlContent = "";
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) { this.htmlContent = htmlContent; }
}