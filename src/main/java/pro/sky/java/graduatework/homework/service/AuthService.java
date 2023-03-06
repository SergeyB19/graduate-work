package pro.sky.java.graduatework.homework.service;

import pro.sky.java.graduatework.homework.dto.RegisterReq;
import pro.sky.java.graduatework.homework.dto.Role;

public interface AuthService {
    boolean login(String userName, String password);
    boolean register(RegisterReq registerReq, Role role);

}
