package com.idalavye.example.a01_bottomappbar;

public class ObjetoListView {

    private String name,message,date;
    private String lastMessges;
    private boolean msjPermission;
    private int countMessage;
    private String txtSmallIcon;
    private int img;

    public ObjetoListView(String name, String message, String date, String lastMessges, boolean msjPermission, int countMessage, String txtSmallIcon,int img) {
        this.name = name;
        this.message = message;
        this.date = date;
        this.lastMessges = lastMessges;
        this.msjPermission = msjPermission;
        this.countMessage = countMessage;
        this.txtSmallIcon = txtSmallIcon;
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLastMessges() {
        return lastMessges;
    }

    public void setLastMessges(String lastMessges) {
        this.lastMessges = lastMessges;
    }

    public boolean isMsjPermission() {
        return msjPermission;
    }

    public void setMsjPermission(boolean msjPermission) {
        this.msjPermission = msjPermission;
    }

    public int getCountMessage() {
        return countMessage;
    }

    public void setCountMessage(int countMessage) {
        this.countMessage = countMessage;
    }

    public String getTxtSmallIcon() {
        return txtSmallIcon;
    }

    public void setTxtSmallIcon(String txtSmallIcon) {
        this.txtSmallIcon = txtSmallIcon;
    }

    @Override
    public String toString() {
        return "ObjetoListView{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", date='" + date + '\'' +
                ", lastMessges='" + lastMessges + '\'' +
                ", msjPermission=" + msjPermission +
                ", countMessage=" + countMessage +
                ", txtSmallIcon='" + txtSmallIcon + '\'' +
                ", img=" + img +
                '}';
    }
}
