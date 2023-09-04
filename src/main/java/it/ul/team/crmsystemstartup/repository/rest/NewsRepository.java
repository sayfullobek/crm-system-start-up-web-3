package it.ul.team.crmsystemstartup.repository.rest;


import it.ul.team.crmsystemstartup.entity.News;
import it.ul.team.crmsystemstartup.projection.CustomNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "list", path = "news" , excerptProjection = CustomNews.class )

public interface NewsRepository extends JpaRepository<News , Integer> {
}
