package op.app.provider.service;

import op.app.protocol.model.entity.TmAgent;
import op.app.protocol.service.TmAgentService;
import op.app.provider.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

import static op.app.util.MatcheUtil.*;

/**
 * Created by gabry on 2017/7/21.
 */
@Service
public class TmAgentServiceImpl implements TmAgentService {
    private String MD5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(s.getBytes("utf-8"));
            return toHex(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String toHex(byte[] bytes) {

        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }


    @Autowired
    private TmAgentRepository repository;
    @Autowired
    private TmAgentCompanyRepository companyRepository;


    @Override
    public long add(TmAgent agent) {
        return 0;
    }

    @Override
    public TmAgent login(String loginName, String password) {
        TmAgent result = null;
        //get login type from loginName
        //search in db
        if (isChinaPhoneLegal(loginName)) {
            //is phone number
            result = repository.getByMobi(loginName);

        } else if (isEmail(loginName)) {
            //is email
            result = repository.getByEmail(loginName);
        } else {
            //TODO:is account name
            result = repository.getByCnName(loginName);
        }
        //password is equal account.password
        if (result != null && !result.password.equals(MD5(password + result.salt))) {
            result = null;
        }
        return result;
    }

    @Override
    public TmAgent reg(String phoneNumber, String password, int verfyCode) throws Exception {
        if (password.isEmpty() || password.length() < 4) {
            throw new Exception("请输入大于4位长度的密码!");
        }
        if (!isChinaPhoneLegal(phoneNumber)) {
            throw new Exception("请输入正确的手机号!");
        }
        //TODO：check verfycode

        if (repository.getByMobi(phoneNumber) != null) {
            throw new Exception("此手机号已被注册!");
        }

        TmAgent model = new TmAgent();
        model.mobi = phoneNumber;
        model.password = password;
        repository.save(model);
        return model;
    }

    @Override
    public void resetPassword(String loginName, String password, String verfyCode) {

    }
}
