package mappings;

import at.bestsolution.persistence.java.ObjectMapperFactoriesProvider;
import at.bestsolution.persistence.ObjectMapper;
import at.bestsolution.persistence.java.ObjectMapperFactory;
import java.util.HashMap;
import java.util.Map;

@org.osgi.service.component.annotations.Component
public final class TasktrackerObjectMapperFactoriesProvider implements ObjectMapperFactoriesProvider {
  private Map<Class<? extends ObjectMapper<?>>, ObjectMapperFactory<?,?>> factories = new HashMap<Class<? extends ObjectMapper<?>>, ObjectMapperFactory<?,?>>();
  public TasktrackerObjectMapperFactoriesProvider() {
    factories.put(at.bestsolution.tasktracker.emapping.ChangeSetMapper.class, new at.bestsolution.tasktracker.emapping.java.ChangeSetMapperFactory());
    factories.put(at.bestsolution.tasktracker.emapping.CommentMapper.class, new at.bestsolution.tasktracker.emapping.java.CommentMapperFactory());
    factories.put(at.bestsolution.tasktracker.emapping.CommentAttachmentMapper.class, new at.bestsolution.tasktracker.emapping.java.CommentAttachmentMapperFactory());
    factories.put(at.bestsolution.tasktracker.emapping.PersonMapper.class, new at.bestsolution.tasktracker.emapping.java.PersonMapperFactory());
    factories.put(at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.class, new at.bestsolution.tasktracker.emapping.java.RepositoryPersonMapperFactory());
    factories.put(at.bestsolution.tasktracker.emapping.SourceRepositoryMapper.class, new at.bestsolution.tasktracker.emapping.java.SourceRepositoryMapperFactory());
    factories.put(at.bestsolution.tasktracker.emapping.TaskMapper.class, new at.bestsolution.tasktracker.emapping.java.TaskMapperFactory());
    factories.put(at.bestsolution.tasktracker.emapping.TaskAttachmentMapper.class, new at.bestsolution.tasktracker.emapping.java.TaskAttachmentMapperFactory());
    factories.put(at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.class, new at.bestsolution.tasktracker.emapping.java.TaskRepositoryMapperFactory());
    factories.put(at.bestsolution.tasktracker.emapping.VersionMapper.class, new at.bestsolution.tasktracker.emapping.java.VersionMapperFactory());
  }

  public Map<Class<? extends ObjectMapper<?>>, ObjectMapperFactory<?,?>> getMapperFactories() {
    return factories;
  }
}
