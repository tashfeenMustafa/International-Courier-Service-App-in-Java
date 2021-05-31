package interfaces;

import assets.Address;
import java.time.LocalDateTime;

public interface QuoteRateAndPrice {
    public float calculatePriceQuote(Address sender, Address recipient);
    public LocalDateTime calculateTimeQuote(Address sender, Address recipient);
}
