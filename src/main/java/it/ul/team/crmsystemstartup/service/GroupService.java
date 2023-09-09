package it.ul.team.crmsystemstartup.service;

import it.ul.team.crmsystemstartup.entity.*;
import it.ul.team.crmsystemstartup.exception.ResourceNotFoundException;
import it.ul.team.crmsystemstartup.implement.serviceImplement.GroupServiceImpl;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.GroupDto;
import it.ul.team.crmsystemstartup.payload.SelectDto;
import it.ul.team.crmsystemstartup.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupService implements GroupServiceImpl {
    private final GroupRepository groupRepository;
    private final AttachmentRepository attachmentRepository;
    private final CourseRepository courseRepository;
    private final AuthRepository authRepository;
    private final WeekDayRepository weekDayRepository;
    private final AttachmentContentRepository attachmentContentRepository;

    @Override
    public List<GroupDto> getGroup() {
        List<Group> all = groupRepository.findAll();
        List<GroupDto> groupDtos = new ArrayList<>();
        List<SelectDto> selectDtos = new ArrayList<>();
        for (Group group : all) {
            selectDtos.add((SelectDto) group.getWeekDays());
            GroupDto groupDto = GroupDto.builder().id(group.getId()).name(group.getName()).teacher(group.getTeacher()).course(group.getCourse()).start_date(group.getStart_date()).end_date(group.getEnd_date()).weekDays(selectDtos).dayTypeName(group.getDayTypeName()).photoId(group.getPhotoId()).active(group.isActive()).build();
            groupDtos.add(groupDto);
        }
        return groupDtos;
    }

    @Override
    public ApiResponse<?> addGroup(GroupDto groupDto) {
        try {
            boolean exist = groupRepository.existsGroupByNameEqualsIgnoreCase(groupDto.getName());
            Course course = courseRepository.findById(groupDto.getCourseId()).orElseThrow(() -> new ResourceNotFoundException(404, "getCourse", "GroupDto", groupDto));
            User teacher = authRepository.findById(groupDto.getTeacherId()).orElseThrow(() -> new ResourceNotFoundException(404, "getTeacher", "GroupDto", groupDto));
            List<Week_day> weekDays = new ArrayList<>();
            for (SelectDto weekDay : groupDto.getWeekDays()) {
                Week_day weekDay1 = weekDayRepository.findById(weekDay.getValue()).orElseThrow(() -> new ResourceNotFoundException(404, "getWekDays", "GroupDto", groupDto));
                weekDays.add(weekDay1);
            }
            if (!exist) {
                Group group = Group.builder().name(groupDto.getName()).course(course).teacher(teacher).dayTypeName(groupDto.getDayTypeName()).start_date(groupDto.getStart_date()).end_date(groupDto.getEnd_date()).weekDays(weekDays).photoId(groupDto.getPhotoId()).active(true).build();
                groupRepository.save(group);
                return new ApiResponse<>("saqlandi", true);
            }
            return new ApiResponse<>("bunday group avaldan mavjud", false);
        } catch (Exception e) {
            return new ApiResponse<>("xatolik", false);
        }
    }

    public ApiResponse<?> addPhoto(UUID groupId, UUID photoId) {
        try {
            Group group = groupRepository.findById(groupId).orElseThrow(() -> new ResourceNotFoundException(404, "getGroup", "groupId", groupId));
            if (group.getPhotoId() == null) {
                group.setPhotoId(photoId);
                groupRepository.save(group);
                return new ApiResponse<>("saqlandi", true);
            } else {
                AttachmentContent byAttachmentId = attachmentContentRepository.findByAttachmentId(group.getPhotoId());
                Attachment get1 = attachmentRepository.findById(group.getPhotoId()).orElseThrow(() -> new ResourceNotFoundException(404, "getPhoto", "PhotoId", photoId));
                attachmentContentRepository.delete(byAttachmentId);
                attachmentRepository.delete(get1);
                group.setPhotoId(photoId);
                groupRepository.save(group);
                return new ApiResponse<>("saqlandi", true);
            }
        } catch (Exception e) {
            return new ApiResponse<>("xatolik", false);
        }
    }

    @Override
    public ApiResponse<?> editeGroup(UUID id, GroupDto groupDto) {
        try {
            Group group = groupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(404, "getGroupId", "groupId", id));
            boolean exist = groupRepository.existsGroupByNameEqualsIgnoreCaseAndIdNot(groupDto.getName(), id);
            List<Week_day> weekDays = new ArrayList<>();
            for (SelectDto weekDay : groupDto.getWeekDays()) {
                Week_day weekDay1 = weekDayRepository.findById(weekDay.getValue()).orElseThrow(() -> new ResourceNotFoundException(404, "getWekDays", "getWekDays", groupDto));
                weekDays.add(weekDay1);
            }
            if (!exist) {
                group.setName(groupDto.getName());
                group.setTeacher(groupDto.getTeacher());
                group.setDayTypeName(groupDto.getDayTypeName());
                group.setCourse(groupDto.getCourse());
                group.setStart_date(groupDto.getStart_date());
                group.setEnd_date(groupDto.getEnd_date());
                group.setWeekDays(weekDays);
                group.setPhotoId(groupDto.getPhotoId());
                groupRepository.save(group);
                return new ApiResponse<>("Taxrirlandi", true);
            } else {
                return new ApiResponse<>("bunday group mavjjud emas", false);
            }
        } catch (Exception e) {
            return new ApiResponse<>("xatolik", false);
        }
    }

    @Override
    public ApiResponse<?> deleteGroup(UUID id) {
        try {
            Group group = groupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(404, "getId", "id", id));
            groupRepository.delete(group);
            return new ApiResponse<>("uchirildi", true);
        } catch (Exception e) {
            return new ApiResponse<>("xatolik uka", false);
        }
    }

    @Override
    public ApiResponse<?> changeActive(UUID id, boolean active) {
        try {
            Group group = groupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(404, "getActive", "id", id));
            group.setActive(active);
            groupRepository.save(group);
            return new ApiResponse<>("Almashtitildi", true);
        } catch (Exception e) {
            return new ApiResponse<>("xatolik", false);
        }
    }
}
