package me.jcsawyer.classroombot.commands;

import me.jcsawyer.classroombot.CommandEvent;
import me.jcsawyer.classroombot.commands.Command;
import me.jcsawyer.classroombot.entities.Teacher;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

public class MakeTeacher extends Command{

    static String[] commands = {"maketeacher", "createteacher", "setteacher"};

    // !maketeacher @teacher title firstname lastname
    public MakeTeacher() {
        super("Make Teacher", "Creates a Teacher.", "`!maketeacher`", commands, "admin");
        this.requiredUserPermissions = new Permission[]{Permission.ADMINISTRATOR}; // User must have administrator privileges
    }

    @Override
    public void handleCommand(CommandEvent event) {
      
      if(event.getArgs().length < 3) {
        event.reply("Please specify title, first name, and last name.");
      }
      
      Member member = event.getMember();
      
      String[] args = event.getArgs();
      
      String title = args[0];
      String firstName = args[1];
      String secondName = args[2];
      
      Role teacherRole = null; //to get from DB
      Teacher teacher = new Teacher(event.getAuthor().getIdLong(), firstName, secondName, title);
      
      event.getGuild().addRoleToMember(member, teacherRole).reason("Registered as Teacher by: " + member.getEffectiveName());
    }

    @Override
    public boolean requireGuild() {
        return true;
    }
}
