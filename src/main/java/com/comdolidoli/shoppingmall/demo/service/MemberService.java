package com.comdolidoli.shoppingmall.demo.service;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.comdolidoli.shoppingmall.demo.domain.Role;
import com.comdolidoli.shoppingmall.demo.domain.entity.MemberEntity;
import com.comdolidoli.shoppingmall.demo.domain.repository.MemberRepository;
import com.comdolidoli.shoppingmall.demo.dto.MemberDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService{

    private MemberRepository memberRepository;

    @Transactional
    public Long joinUser(MemberDto memberDto){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        return memberRepository.save(memberDto.toEntity()).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Optional<MemberEntity> userEntityWrapper = memberRepository.findByEmail(email);

        MemberEntity memberEntity = userEntityWrapper.get();
        List<GrantedAuthority> authorities = new ArrayList<>();

        if(("admin@example").equals(email)){
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        }else{
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return new User(memberEntity.getEmail(),memberEntity.getPassword(),authorities);
    }
}
