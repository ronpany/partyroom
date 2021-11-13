package com.partyroom.model.custom;

import com.partyroom.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author desaextremo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountClient {
    private Long total;
    private Client client;
}
