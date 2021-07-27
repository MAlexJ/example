package com.malex.lecture_26_SDL.chapter_5_linked_list.impl;

import com.malex.lecture_26_SDL.chapter_5_linked_list.ILinkedList;
import com.malex.lecture_26_SDL.chapter_5_linked_list.INode;

import java.util.Objects;

public class MyLinkedList implements ILinkedList {

    private int size = 0;

    /**
     * Pointer to first node.
     * Invariant: (first == null && last == null) ||
     * (first.prev == null && first.item != null)
     */
    private INode first;

    /**
     * Pointer to last node.
     * Invariant: (first == null && last == null) ||
     * (last.next == null && last.item != null)
     */
    private INode last;

    @Override
    public void add(String elem) {
        if (Objects.isNull(first)) {
            first = new INode(null, elem, null);
            last = first;
        } else {
            INode node = new INode(last, elem, null);
            last.setNext(node);
            last = node;
        }
        size++;
    }

    @Override
    public boolean remove(Object o) {
        if (size <= 0) {
            return false;
        }

        String elem = Objects.isNull(o) ? null : (String) o;
        if (first.getValue() == null || first.getValue().equals(elem)) {
            INode temp = first.getNext();
            first.setNext(null);
            first = temp;
            size--;
            return true;
        }
        if (last.getValue() == null || last.getValue().equals(elem)) {
            INode temp = last.getPrev();
            last.setPrev(null);
            last = temp;
            size--;
            return true;
        }

        if (Objects.isNull(o)) {
            INode tmp = this.first;
            while (Objects.nonNull(tmp)) {
                if (Objects.isNull(tmp.getValue())) {
                    exchangeLinksToNodes(tmp);
                    size--;
                    return true;
                }
                tmp = tmp.getNext();
            }
            return false;
        }

        INode tmp = this.first;
        while (Objects.nonNull(tmp)) {
            if (tmp.getValue().equals(elem)) {
                exchangeLinksToNodes(tmp);
                size--;
                return true;
            }
            tmp = tmp.getNext();
        }
        return false;
    }


    private void exchangeLinksToNodes(INode tmp) {
        INode prev = tmp.getPrev();
        INode next = tmp.getNext();
        if (Objects.nonNull(prev)) {
            prev.setNext(next);
        }
        if (Objects.nonNull(next)) {
            next.setPrev(prev);
        }
        tmp.setPrev(null);
        tmp.setNext(null);
    }


    @Override
    public void addFirst(String element) {

    }

    @Override
    public void addLast(String element) {

    }

    @Override
    public String removeFirst() {
        return null;
    }

    @Override
    public String removeLast() {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }
}
