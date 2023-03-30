package com.springclass.firstproject.dto.pagenated;

import com.springclass.firstproject.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PagenatedResponaseItemDTO {
    private List<ItemDTO> list;
    private long count;
}
