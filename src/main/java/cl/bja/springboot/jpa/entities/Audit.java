package cl.bja.springboot.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.hibernate.annotations.Formula;

import java.time.LocalDateTime;

@Embeddable
public class Audit {
    @Column(name = "create_at")
    private LocalDateTime creatAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Formula("0")       // Evitando que el componente sea NULL. Solo añadir este campo
    private int dummy;

    @PrePersist
    public void prePersist() {
        System.out.println("evento del ciclo de vida del entity pre-persist");
        this.creatAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println("evento del ciclo de vida del objeto entity pre-update");
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {
        return creatAt;
    }

    public void setCreatAt(LocalDateTime creatAt) {
        this.creatAt = creatAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
