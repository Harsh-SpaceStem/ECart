package com.spacestem.ecart.model;

public class ProfileItem {
    private int profileItemImage;
    private String profileItemName;

    public ProfileItem() {
    }

    public ProfileItem(int profileItemImage, String profileItemName) {
        this.profileItemImage = profileItemImage;
        this.profileItemName = profileItemName;
    }

    public int getProfileItemImage() {
        return profileItemImage;
    }

    public void setProfileItemImage(int profileItemImage) {
        this.profileItemImage = profileItemImage;
    }

    public String getProfileItemName() {
        return profileItemName;
    }

    public void setProfileItemName(String profileItemName) {
        this.profileItemName = profileItemName;
    }
}
