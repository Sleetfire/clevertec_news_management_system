package ru.clevertec.news_management_service.repository.entity;

import java.io.Serializable;

public interface BaseEntity<T extends Serializable> {

    T getId();

}
