package demo.alliance.ne.binarysupermarket.services;

import demo.alliance.ne.binarysupermarket.models.User;


public interface IUserService {

    User create(User user);

    boolean isNotUnique(User user);

    void validateNewRegistration(User user);

    User getLoggedInUser();

}