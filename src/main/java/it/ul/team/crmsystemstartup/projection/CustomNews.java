package it.ul.team.crmsystemstartup.projection;


import org.springframework.data.rest.core.config.Projection;

import javax.persistence.Column;

@Projection(name = "CustomNews", types = CustomNews.class)
public interface CustomNews {
     Integer id();

     String message();

     String name();

     Integer photoId();

     Integer videoId();
}
