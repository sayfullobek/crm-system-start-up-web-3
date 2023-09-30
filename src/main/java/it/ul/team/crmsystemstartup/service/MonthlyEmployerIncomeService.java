package it.ul.team.crmsystemstartup.service;

import it.ul.team.crmsystemstartup.entity.Group;
import it.ul.team.crmsystemstartup.entity.MonthlyEmployerIncome;
import it.ul.team.crmsystemstartup.entity.User;
import it.ul.team.crmsystemstartup.exception.ResourceNotFoundException;
import it.ul.team.crmsystemstartup.implement.serviceImplement.MonthlyEmployerIncomeServiceImpl;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.MonthlyEmployerIncomeDto;
import it.ul.team.crmsystemstartup.repository.AuthRepository;
import it.ul.team.crmsystemstartup.repository.GroupRepository;
import it.ul.team.crmsystemstartup.repository.MonthlyEmployerIncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MonthlyEmployerIncomeService implements MonthlyEmployerIncomeServiceImpl {
    private final MonthlyEmployerIncomeRepository monthlyEmployerIncomeRepository;
    private final AuthRepository authRepository;
    private final GroupRepository groupRepository;

    @Override
    public List<MonthlyEmployerIncomeDto> getMonthlyEmployerIncome() {
        return null;
    }

    @Override
    public ApiResponse<?> addMonthlyEmployerIncome(MonthlyEmployerIncomeDto monthlyEmployerIncomeDto) {
        try {
            User user = authRepository.findById(monthlyEmployerIncomeDto.getTeacherId()).orElseThrow(() -> new ResourceNotFoundException(404, "id", "teacher", monthlyEmployerIncomeDto.getTeacherId()));
            MonthlyEmployerIncome monthlyEmployerIncome = monthlyEmployerIncomeRepository.findMonthlyEmployerIncomeByTeachersId(user.getId()).orElseThrow(() -> new ResourceNotFoundException(404, "id", "teacher", monthlyEmployerIncomeDto.getTeacherId()));
            if (monthlyEmployerIncome != null) {
                double allTeacherPrice = 0;
                for (Group group : groupRepository.findAll()) {
                    if (group.getTeacher().equals(user)) {
                        allTeacherPrice = allTeacherPrice + group.getCourse().getPrice() * group.getPupil().size() * (monthlyEmployerIncomeDto.getPercent() / 100);
                    }
                }
                MonthlyEmployerIncome build = MonthlyEmployerIncome.builder()
                        .teachers(Collections.singletonList(user))
                        .sum(allTeacherPrice)
                        .month(LocalDate.now().toString())
                        .percent(monthlyEmployerIncomeDto.getPercent())
                        .allInCome(monthlyEmployerIncome.getAllInCome() + allTeacherPrice)
                        .build();
                monthlyEmployerIncomeRepository.save(build);
                return new ApiResponse<>("Saqlandi", true);
            } else {
                double allTeacherPrice = 0;
                for (Group group : groupRepository.findAll()) {
                    if (group.getTeacher().equals(user)) {
                        allTeacherPrice = allTeacherPrice + group.getCourse().getPrice() * group.getPupil().size() * (monthlyEmployerIncomeDto.getPercent() / 100);
                    }
                }
                MonthlyEmployerIncome build = MonthlyEmployerIncome.builder()
                        .teachers(Collections.singletonList(user))
                        .sum(allTeacherPrice)
                        .month(LocalDate.now().toString())
                        .percent(monthlyEmployerIncomeDto.getPercent())
                        .allInCome(allTeacherPrice)
                        .build();
                return new ApiResponse<>("Saqlandi", true);
            }
        } catch (Exception err) {
            return new ApiResponse<>("Hato", false);
        }
    }
}
