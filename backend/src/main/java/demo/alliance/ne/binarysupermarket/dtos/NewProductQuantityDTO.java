package demo.alliance.ne.binarysupermarket.dtos;

import demo.alliance.ne.binarysupermarket.enums.EProductQuantityOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewProductQuantityDTO {

    @NotBlank
    private String code;

    @NotNull
    private Integer quantity;

    @NotNull
    private EProductQuantityOperation operation;
}