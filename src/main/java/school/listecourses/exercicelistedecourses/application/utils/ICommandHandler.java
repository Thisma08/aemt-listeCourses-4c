package school.listecourses.exercicelistedecourses.application.utils;

public interface ICommandHandler<I, O> {
    O handle(I input);
}
