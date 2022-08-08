package com.comdolidoli.shoppingmall.demo.dto;

import com.comdolidoli.shoppingmall.demo.domain.entity.MemberEntity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {

    private Long id;
    private String name;
    private String password;
    private String email;
    private String nickname;

    @Builder
    public MemberDto(Long id, String name, String password, String email, String nickname) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
    }

    public MemberEntity toEntity(){
        return new MemberEntity(id, name, email, password, nickname);
    }


}
