package com.ItRoid.ServicioUsuarios.services;

public interface MailsService<T>{

    void enviarMail(String destinatario, String plantilla);

}
