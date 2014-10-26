package com.stairways.servlet;

import com.stairways.command.CommandLogin;
import com.stairways.command.CommandMain;
import com.stairways.command.CommandMissing;
import com.stairways.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by matvey on 21.10.14.
 */

public class ControllerHelper {
    private static ControllerHelper instance = null;
    HashMap<String, ICommand> commands = new HashMap<String, ICommand>();

    private ControllerHelper() {
        commands.put("main", new CommandMain());
        commands.put("error", new CommandMissing());
        commands.put("index", new CommandLogin());
    }

    public ICommand getCommand(HttpServletRequest request) {
        ICommand command = commands.get(request.getParameter("command"));
        if (command == null) {
            command = new CommandMissing();
        }
        return command;
    }

    public static ControllerHelper getInstance() {
        if (instance == null) {
            instance = new ControllerHelper();
        }
        return instance;
    }
}
