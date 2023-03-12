import java.util.ArrayList;

class WebPage {
    private final String title;
    private final String url;
    private final String description;
    private final ArrayList<String> keywords;
    private final String author;
    private final String content;

    //생성자
    private WebPage(WebPageBuilder builder) {
        this.title = builder.title;
        this.url = builder.url;
        this.keywords = builder.keywords;
        this.description = builder.description;
        this.author = builder.author;
        this.content = builder.content;
    }
    public static class WebPageBuilder {
        private String title;
        private String url;
        private String description;
        private ArrayList<String> keywords;
        private String author;
        private String content;

        public WebPageBuilder(String title, String url) {
            this.title = title;
            this.url = url;
        }

        public WebPageBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public WebPageBuilder setKeywords(ArrayList<String> keywords) {
            this.keywords = keywords;
            return this;
        }

        public WebPageBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public WebPageBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        public WebPage build() {
            return new WebPage(this);
        }
    }//end of WebPageBuilder

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
public class Main {
    public static void main(String[] args) {

        ArrayList<String> items = new ArrayList<String>();
        items.add("테스트");
        items.add("html page");
        items.add("홈페이지");

        WebPage webPage1 = new WebPage.WebPageBuilder("홈페이지", "https://www.verthasystem.co.kr")
                .setDescription("이 곳은 웹 첫페이지 테스트 입니다.")
                .setAuthor("하성호")
                .setContent("<htmnl><body><h1>안녕하세요! </h1></body></html>")
                .setKeywords(items)
                .build();

        System.out.println(webPage1.getTitle() + ": " + webPage1.getUrl());
        System.out.println("작성자 : " + webPage1.getAuthor());
        System.out.println("부가설명 : " + webPage1.getDescription());
        System.out.println("내용 : " + webPage1.getContent());
        System.out.println("키워드 : " + webPage1.getKeywords());
    }
}
/*
출력결과
홈페이지: https://www.verthasystem.co.kr
작성자 : 하성호
부가설명 : 이 곳은 웹 첫페이지 테스트 입니다.
내용 : <htmnl><body><h1>안녕하세요! </h1></body></html>
키워드 : [테스트, html page, 홈페이지]
*/
