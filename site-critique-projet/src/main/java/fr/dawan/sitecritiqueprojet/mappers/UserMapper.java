package fr.dawan.sitecritiqueprojet.mappers;

import org.modelmapper.ModelMapper;

import fr.dawan.sitecritiqueprojet.beans.User;
import fr.dawan.sitecritiqueprojet.dto.UserDto;

public class UserMapper {
    private ModelMapper mapper;

    public UserMapper() {
        mapper = new ModelMapper();
    }

    public UserDto toDto(User u) {
        mapper.typeMap(User.class, UserDto.class).addMappings(mapper -> {
            mapper.map(src -> src.getId(), UserDto::setId);
            mapper.map(src -> src.getUsername(), UserDto::setUsername);
            mapper.map(src -> src.getLastname(), UserDto::setLastname);
            mapper.map(src -> src.getFirstname(), UserDto::setFirstname);
            mapper.map(src -> src.getEmail(), UserDto::setEmail);
            mapper.map(src -> src.isEnabled(), UserDto::setEnabled);
            mapper.map(src -> src.getRoles(), UserDto::setRoles);
        });
        return mapper.map(u, UserDto.class);
    }

    public User fromDto(UserDto uDto) {
        mapper.typeMap(UserDto.class, User.class).addMappings(mapper -> {
            mapper.map(src -> src.getId(), User::setId);
            mapper.map(src -> src.getUsername(), User::setUsername);
            mapper.map(src -> src.getLastname(), User::setLastname);
            mapper.map(src -> src.getFirstname(), User::setFirstname);
            mapper.map(src -> src.getEmail(), User::setEmail);
            mapper.map(src -> src.getRoles(), User::setRoles);
        });
        return mapper.map(uDto, User.class);
    }
}
