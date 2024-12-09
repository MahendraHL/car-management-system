package com.pls.cms.dao;

import com.pls.cms.model.User;

public interface UserDaoo {
    User getAdminByUsername(String email);
}
