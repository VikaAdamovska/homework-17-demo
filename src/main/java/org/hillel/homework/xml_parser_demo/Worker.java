package org.hillel.homework.xml_parser_demo;

public class Worker {

    private String login;

    private String position;

    private String company;

    private int sinceYear;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getSinceYear() {
        return sinceYear;
    }

    public void setSinceYear(int sinceYear) {
        this.sinceYear = sinceYear;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "login='" + login + '\'' +
                ", position='" + position + '\'' +
                ", company='" + company + '\'' +
                ", sinceYear=" + sinceYear +
                '}';
    }
}
