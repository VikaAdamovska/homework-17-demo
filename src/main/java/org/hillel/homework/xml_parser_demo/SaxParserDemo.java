package org.hillel.homework.xml_parser_demo;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class Handler extends DefaultHandler {

    private List<Worker> workers;
    private Worker worker;
    private StringBuilder info;

    private boolean isLogin = false;
    private boolean isPosition = false;

    public List<Worker> getWorkers() {
        return workers;
    }

    @Override
    public void startDocument() throws SAXException {
        workers = new ArrayList<>();
    }


    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("worker")) {
            worker = new Worker();
            workers.add(worker);
        } else if (qName.equalsIgnoreCase("login")) {
            isLogin = true;
        } else if (qName.equalsIgnoreCase("position")) {
            isPosition = true;
        } else if (qName.equalsIgnoreCase("additionalInfo")) {
            String year = attributes.getValue("sinceYear");
            String company = attributes.getValue("company");
            worker.setSinceYear(Integer.parseInt(year));
            worker.setCompany(company);
        }
        this.info = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (isLogin) {
            worker.setLogin(info.toString());
            isLogin = false;
        } else if (isPosition) {
            worker.setPosition(info.toString());
            isPosition = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        info.append(new String(ch, start, length));
    }
}


public class SaxParserDemo {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        InputStream xmlInputStream = SaxParserDemo.class.getResourceAsStream("file_test.xml");
        Handler handler = new Handler();
        SAXParser parser = parserFactory.newSAXParser();
        parser.parse(xmlInputStream, handler);

        List<Worker> workers = handler.getWorkers();
        for (Worker worker : workers) {
            System.out.println(worker);
        }
    }
}
