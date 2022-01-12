package com.externalapi.externalapi.Models;

import lombok.*;
import java.time.LocalDateTime;

@Data // shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, @Setter (non final filds) @Required Constructor
@AllArgsConstructor //@AllArgsConstructor gera um construtor com 1 parâmetro para cada campo em sua classe. Os campos marcados com @NonNull resultam em verificações nulas nesses parâmetros.
//@NoArgsConstructor
public class Todo {
    private String id;
    private String todo;
    private String description;
    private Boolean completed;
//    @NotNull
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    // @Builder.Default
    private LocalDateTime createAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    public Todo() {
    }

    public void setDataUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
}
