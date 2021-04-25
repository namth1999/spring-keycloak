package com.example.springkeycloak.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
@Builder
public class Product implements Serializable {

    @NotNull
    @Size(max = 64)
    @Id
    private String id;

    @NotNull
    @Size(max = 1024)
    @Column(name = "name", length = 1024, nullable = false)
    private String name;

    @NotNull
    @Size(max = 64)
    @Column(name = "provider_id", length = 64, nullable = false)
    private String providerId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        return id != null && id.equals(((Product) o).id);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Product{" +
                "id=" + getId() +
                ", name='" + getName() + "'" +
                ", providerId='" + getProviderId() + "'" +
                "}";
    }

}