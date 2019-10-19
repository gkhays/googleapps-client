package org.gkh.google.client.model;

import java.util.List;

public class UserListModel {

	private final String kind;
    private final List<UserModel> tasks;

    public UserListModel(String kind, List<UserModel> tasks) {
        this.kind = kind;
        this.tasks = tasks;
    }

    public String getKind() {
        return kind;
    }

    public List<UserModel> getUsers() {
        return tasks;
    }
    
}
