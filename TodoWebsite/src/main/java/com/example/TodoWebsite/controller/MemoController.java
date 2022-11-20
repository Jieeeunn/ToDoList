package com.example.TodoWebsite.controller;

import com.example.TodoWebsite.domain.Memo;
import com.example.TodoWebsite.dto.MemoSaveRequestDto;
import com.example.TodoWebsite.dto.MemoUpdateRequestDto;
import com.example.TodoWebsite.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Long createMemo(@RequestBody MemoSaveRequestDto requestDto) {
        return memoService.createMemo(requestDto);
    }

    @GetMapping("/api/memos")
    public List<Memo> findAllMemo() {
        return memoService.findAllMemo();
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoUpdateRequestDto requestDto) {
        return memoService.updateMemo(id, requestDto);
    }

    @DeleteMapping("/api/memos/{id}")
    public void deleteMemo(@PathVariable Long id) {
        memoService.deleteMemo(id);
    }
}
