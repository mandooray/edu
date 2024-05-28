package com.example.edu.service;

import com.example.edu.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MemberService {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    private String HASH_NAME = "Member:";

    public Member saveUser(Member member) {
//        UUID uuid = UUID.randomUUID();
//        member.setId(uuid.toString());
        redisTemplate.opsForHash().put(HASH_NAME, member.getId(), member);

        return member;
    }

    public List<Member> getList() {
        Map<Object, Object> entries = redisTemplate.opsForHash().entries(HASH_NAME);
        return entries.values().stream().map(e->(Member)e).collect(Collectors.toList());

    }
    public Member getMember(String memberId) {
        Object result = redisTemplate.opsForHash().get(HASH_NAME, memberId);
        if (result == null) {
            //TODO throw
        }
        return (Member) result;

    }
//
//    public Member getMember(String memberId) {
//
//
//    }
}
