package com.malex.lecture_26_SDL.chapter_5_linked_list;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class INode {

    private String value;
    private INode next;
    private INode prev;

    public INode(INode prev, String value, INode next) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}