package com.marcin.service;

import javax.mail.MessagingException;

public interface MailService {

    void SendMail(String to, String subject, String text, boolean isHtmlContent) throws MessagingException;
}
