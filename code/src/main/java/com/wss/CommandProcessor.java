package com.wss;

public class CommandProcessor {
    private static CommandProcessor root;
    private InMemory memory;
    private CommandProcessor next, pre;

    static CommandProcessor init() {
        if (null == root) {
            root = new CommandProcessor(new InMemory());
        }
        return root;
    }

    private CommandProcessor(InMemory memory) {
        this.memory = memory;
    }

    public CommandProcessor start() {
        next = new CommandProcessor(new InMemory(this.memory));
        next.pre = this;
        return next;
    }

    public CommandProcessor commit() {
        pre.memory.map.putAll(memory.map);
        if ( this == root) {
            return root;
        }
        pre.next = null;
        return pre;
    }

    public CommandProcessor abort() {
        if ( this == root) {
            return root;
        }
        pre.next = null;
        return pre;
    }

    public void quit() {
        System.out.println("Exiting...");
        System.exit(0);
    }

    public String read(String key) {
        return memory.read(key);
    }

    public void write(String key, String value) {
        memory.write(key, value);
    }

    public void delete(String key) {
        memory.delete(key);
    }
}
