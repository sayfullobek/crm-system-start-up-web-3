package it.ul.team.crmsystemstartup.service;

import it.ul.team.crmsystemstartup.entity.*;
import it.ul.team.crmsystemstartup.entity.enums.DayTypeName;
import it.ul.team.crmsystemstartup.exception.ResourceNotFoundException;
import it.ul.team.crmsystemstartup.implement.serviceImplement.GroupServiceImpl;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.GroupDto;
import it.ul.team.crmsystemstartup.payload.SelectDto;
import it.ul.team.crmsystemstartup.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
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
    private final PupilSaleRepository pupilSaleRepository;
    private final WeekDayRepository weekDayRepository;
    private final AttachmentContentRepository attachmentContentRepository;

    @Override
    public List<GroupDto> getGroup() {
        return null;
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
              Group group = Group.builder()
                      .name(groupDto.getName())
                      .course(course)
                      .teacher(teacher)
                      .dayTypeName(groupDto.getDayTypeName() == 1 ? DayTypeName.TOQ : groupDto.getDayTypeName() == 2 ? DayTypeName.JUFT : DayTypeName.BOOTCAMP)
                      .start_date(groupDto.getStart_date())
                      .end_date(groupDto.getEnd_date())
                      .weekDays(weekDays)
                      .isActive(true)
                      .build();
              groupRepository.save(group);
              return  new ApiResponse<>("saqlandi",true);
          }
          return new ApiResponse<>("bunday group avaldan mavjud",false);
      }catch (Exception e){
          return new ApiResponse<>("xatolik",false);
      }
    }

    public ApiResponse<?> addPhoto(UUID groupId,UUID photoId){
        try {
            Group group = groupRepository.findById(groupId).orElseThrow(() -> new ResourceNotFoundException(404, "getGroup", "groupId", groupId));
            if (group.getPhotoId()==null){
                group.setPhotoId(photoId);
                groupRepository.save(group);
                return  new ApiResponse<>("saqlandi",true);
            }else {
                AttachmentContent byAttachmentId = attachmentContentRepository.findByAttachmentId(group.getPhotoId());
                Attachment get1 = attachmentRepository.findById(group.getPhotoId()).orElseThrow(() -> new ResourceNotFoundException(404, "getPhoto", "PhotoId", photoId));
                attachmentContentRepository.delete(byAttachmentId);
                attachmentRepository.delete(get1);
                group.setPhotoId(photoId);
                groupRepository.save(group);
                return new ApiResponse<>("saqlandi",true);
            }
        }catch (Exception e){
            return  new ApiResponse<>("xatolik",false);
        }
    }

    @Override
    public ApiResponse<?> editeGroup(UUID id, GroupDto groupDto) {
        return null;
    }

    @Override
    public ApiResponse<?> deleteGroup(UUID id) {
        return null;
    }
}
