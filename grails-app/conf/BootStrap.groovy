class BootStrap {

     def init = { servletContext ->
         // Add some hotels
        new Customer(username: 'keith', name: 'Keith').save()
        new Customer(username: 'erwin', name: 'Erwin').save()
        new Customer(username: 'jeremy', name: 'Jeremy').save()
        new Customer(username: 'scott', name: 'Scott').save()
        new Hotel(price: 199, name: 'Westin Diplomat', address: '3555 S. Ocean Drive', city: 'Hollywood', state: 'FL', zip: '33019', country: 'USA').save()
        new Hotel(price: 60, name: 'Jameson Inn', address:'890 Palm Bay Rd NE', city:'Palm Bay', state: 'FL', zip: '32905', country: 'USA').save()
        new Hotel(price: 199, name:'Chilworth Manor', address:'The Cottage, Southampton Business Park', city:'Southampton', state: 'Hants', zip: 'SO16 7JF', country: 'UK').save()
        new Hotel(price: 120, name:'Marriott Courtyard', address:'Tower Place, Buckhead', city:'Atlanta', state: 'GA', zip: '30305', country: 'USA').save()
        new Hotel(price: 180, name:'Doubletree', address:'Tower Place, Buckhead', city:'Atlanta', state: 'GA', zip: '30305', country: 'USA').save()
        new Hotel(price: 450, name:'W Hotel', address:'Union Square, Manhattan',city: 'NY', state: 'NY', zip: '10011', country: 'USA').save()
        new Hotel(price: 450, name:'W Hotel', address:'Lexington Ave, Manhattan', city:'NY', state: 'NY', zip: '10011', country: 'USA').save()
        new Hotel(price: 250, name:'Hotel Rouge', address:'1315 16th Street NW', city:'Washington', state: 'DC', zip: '20036', country: 'USA').save()
        new Hotel(price: 300, name:'70 Park Avenue Hotel', address:'70 Park Avenue', city:'NY', state: 'NY', zip: '10011', country: 'USA').save()
        new Hotel(price: 300, name:'Conrad Miami', address:'1395 Brickell Ave', city:'Miami', state: 'FL', zip: '33131', country: 'USA').save()
        new Hotel(price: 80, name: 'Sea Horse Inn', address:'2106 N Clairemont Ave', city:'Eau Claire', state: 'WI', zip: '54703', country: 'USA').save()
        new Hotel(price: 90, name:'Super 8 Eau Claire Campus Area', address:'1151 W Macarthur Ave', city:'Eau Claire', state: 'WI', zip:  '54701', country: 'USA').save()
        new Hotel(price: 160, name:'Marriot Downtown', address:'55 Fourth Street', city:'San Francisco', state: 'CA', zip: '94103', country: 'USA').save()
        new Hotel(price: 200, name:'Hilton Diagonal Mar', address:'Passeig del Taulat 262-264', city:'Barcelona', state: 'Catalunya', zip: '08019', country: 'Spain').save()
        new Hotel(price: 210, name:'Hilton Ramallah', address:'Independence Park', city:'Ramallah', state: '', zip: '63405', country: 'Palestine').save()
        new Hotel(price: 240, name:'InterContinental Tokyo Bay',address: 'Takeshiba Pier', city:'Tokyo', state: '', zip: '105', country: 'Japan').save()
        new Hotel(price: 130, name:'Hotel Beaulac', address:' Esplanade Léopold-Robert 2',city: 'Neuchatel',state:  '', zip: '2000', country: 'Switzerland').save()
        new Hotel(price: 140, name:'Conrad Treasury Place', address:'William & George Streets', city:'Brisbane', state: 'QLD', zip: '4001', country: 'Australia').save()
        new Hotel(price: 230, name:'Ritz Carlton', address:'1228 Sherbrooke St', city:'West Montreal', state: 'Quebec', zip: 'H3G1H6', country: 'Canada').save()
        new Hotel(price: 460, name:'Ritz Carlton', address:'Peachtree Rd, Buckhead', city:'Atlanta',state:  'GA', zip: '30326', country: 'USA').save()
        new Hotel(price: 220, name:'Swissotel', address:'68 Market Street', city:'Sydney', state: 'NSW', zip: '2000', country: 'Australia').save()
        new Hotel(price: 250, name:'Meliá White House', address:'Albany Street', city:'Regents Park London', state: '', zip: 'NW13UP', country: 'Great Britain').save()
        new Hotel(price: 210, name:'Hotel Allegro', address:'171 West Randolph Street', city:'Chicago', state: 'IL', zip: '60601', country: 'USA').save()
     }

     def destroy = {
     }
} 