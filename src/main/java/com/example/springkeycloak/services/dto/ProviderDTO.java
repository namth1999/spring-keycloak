package com.example.springkeycloak.services.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class ProviderDTO  implements Serializable {

    private String id;

    @NotNull
    @Size(max = 1024)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProviderDTO)) {
            return false;
        }
        return id != null && id.equals(((ProviderDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 2;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProviderDTO{" +
                "id=" + getId() +
                ", name='" + getName() + "'" +
                "}";
    }
}
