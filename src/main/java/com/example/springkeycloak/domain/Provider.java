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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "provider")
@Builder
public class Provider {

    @NotNull
    @Size(max = 64)
    @Id
    private String id;

    @NotNull
    @Size(max = 1024)
    @Column(name = "name", length = 1024, nullable = false)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Provider)) {
            return false;
        }
        return id != null && id.equals(((Provider) o).id);
    }

    @Override
    public int hashCode() {
        return 2;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Provider{" +
                "id=" + getId() +
                ", name='" + getName() + "'" +
                "}";
    }
}
